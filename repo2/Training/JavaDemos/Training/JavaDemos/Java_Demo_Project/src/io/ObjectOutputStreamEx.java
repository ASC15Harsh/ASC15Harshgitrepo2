package io;

import java.io.*;

public class ObjectOutputStreamEx {
    public static void main(String[] args) {
        File file = new File("product.dat");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ProductModel productModel = new ProductModel("P03", "Laptop", 500.50f);
            objectOutputStream.writeObject(productModel);
            productModel = new ProductModel("P02", "Mobile", 100.50f);
            objectOutputStream.writeObject(productModel);
            System.out.println("Product details are written to the file");
        } catch (FileNotFoundException fileNotFoundException ) {
            System.out.println("Exception :: " + fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println("Exception:> " + ioException.getMessage());
        }
    }
}
