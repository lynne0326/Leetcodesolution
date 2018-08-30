package Lyft.imageurl;

import java.io.*;

/**
 * Created by lingyanjiang on 17/1/23.
 */
public class Main {
    public void processImageURL(String inputFilePath, String outputFilePath) {
        try {
            BufferedReader bufIn = new BufferedReader(new FileReader(new File(inputFilePath)));
            BufferedWriter bufOut = new BufferedWriter(new FileWriter(new File(outputFilePath)));
            Downloader downloader = new Downloader();

            int capacity = Integer.parseInt(bufIn.readLine());
            LRUCache cache = new LRUCache(capacity);
            int urlCounts = Integer.parseInt(bufIn.readLine());
            for (int i = 0; i < urlCounts; i++) {
                String url = bufIn.readLine();
                Image image = cache.get(url);
                bufOut.write(url + " ");
                if (image == null) {
                    image = downloader.downloadImage(url);
                    cache.set(url, image);
                    bufOut.write("DOWNLOADED " + image.size);
                } else {
                    bufOut.write("IN_CACHE " + image.size);
                }
                bufOut.newLine();
            }

            bufIn.close();
            bufOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().processImageURL("input.txt", "output.txt");
    }
}
