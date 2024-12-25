package com.example.epj2.model.rent;

import com.example.epj2.controller.MainWindowController;
import com.example.epj2.model.Configuration;
import javafx.application.Platform;

import java.nio.file.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * The class is responsible for monitoring changes in files and reacting to them in accordance with logic.
 */
public class FileWatcher{


    /**
     * The method is used to monitor changes in folder where invoices in form of text file should be added after creation.
     * If the change is identified, the corresponding text file is read and its content is added to Invoice object.
     */
    public void check(){
            try{
                String filePath = Thread.currentThread().getContextClassLoader().getResource(Configuration.getPropertiesFile()).getPath();
                Properties properties = new Properties();
                properties.load(new FileInputStream(filePath));
                String folder = Configuration.getInvoicePathProp();
                WatchService watcher = FileSystems.getDefault().newWatchService();
                Path path = Paths.get(Configuration.getUserDirProp() + File.separator + folder);
                path.register(watcher, ENTRY_MODIFY);

                while(true){
                    WatchKey key = watcher.take();
                    for(WatchEvent<?> event : key.pollEvents()){
                        WatchEvent.Kind<?> kind = event.kind();
                        WatchEvent<Path> ev = (WatchEvent)event;
                        Path newFile = ev.context();

                        if(kind == ENTRY_MODIFY){
                            //System.out.println("Modified! "+ newFile.toString() + " in folder "+ folder);
                            Platform.runLater(()-> {
                                try {
                                    List<String> fileContent = Files.readAllLines(Paths.get(Configuration.getUserDirProp() + File.separator + folder + File.separatorChar + newFile));
                                    int rentId = parseLineToInt(fileContent.get(1));
                                    String userId = parseLine(fileContent.get(4));
                                    String userLicence = parseLine(fileContent.get(5));
                                    String vehicleId = parseLine(fileContent.get(3));
                                    double primaryPrice = parseLineToDouble(fileContent.get(7));
                                    double distance = parseLineToDouble(fileContent.get(8));
                                    double promotion = parseLineToDouble(fileContent.get(9));
                                    double discount = parseLineToDouble(fileContent.get(10));
                                    double finalPrice = parseLineToDouble(fileContent.get(12));
                                    LocalDateTime localDateTime = parseLineToLocalDateTime(fileContent.get(0));
                                    Invoice invoice = new Invoice(rentId, userId, userLicence, vehicleId, primaryPrice, finalPrice, promotion, discount, distance, localDateTime);
                                    MainWindowController.invoiceList.add(invoice);
                                    MainWindowController.updateInvoicesDateMap();
                                    MainWindowController.updateReportList();
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });

                        }
                    }
                    key.reset();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    private double parseLineToDouble(String line) {
        String [] parts = line.split(":");
        return Double.parseDouble(parts[1]);
    }

    private int parseLineToInt(String line) {
        String [] parts = line.split(":");
        return Integer.parseInt(parts[1].replace(" ",""));
    }

    private String parseLine(String line) {
        String [] parts = line.split(":");
        return parts[1].replace(" ","");
    }

    private LocalDateTime parseLineToLocalDateTime(String line) {
        String [] parts = line.split(":");
        String time = parts[1].replace(" ","").concat(":" + parts[2]);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return  LocalDateTime.parse(time,formatter);
    }

}

