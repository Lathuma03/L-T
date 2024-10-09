package com.inventorymanagement;
import java.util.HashMap;
public class Admin {

    private String adminId;
    private String password;
    private static HashMap<String, String> adminCredentials = new HashMap<>();

    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }

    public static void register(String id, String password) {
        adminCredentials.put(id, password);
        System.out.println("Admin registered successfully.");
    }

    public static boolean login(String id, String password) {
        return adminCredentials.containsKey(id) && adminCredentials.get(id).equals(password);
    }
}
