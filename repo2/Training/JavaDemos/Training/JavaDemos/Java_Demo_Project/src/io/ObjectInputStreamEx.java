package io;

import java.io.*;

public class ObjectInputStreamEx {
    public static void main(String[] args) {
        File file = new File("product.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ProductModel productModel = new ProductModel("P01", "Laptop", 500.50f);


            Object productModelObject = objectInputStream.readObject();
            ProductModel productModel1 = (ProductModel) productModelObject;
            System.out.println(productModel1);

            ((ProductModel) (objectInputStream.readObject())).displayDetails();
        } catch (FileNotFoundException fileNotFoundException ) {
            System.out.println("Exception :: " + fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println("Exception:> " + ioException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Exception:> " + classNotFoundException.getMessage());
        }
    }
}
