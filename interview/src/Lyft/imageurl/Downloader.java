package Lyft.imageurl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lingyanjiang on 17/1/23.
 */
public class Downloader {

    public Image downloadImage(String urlStr) {
        Image image = null;
        try {
            URL url = new URL(urlStr);
            image = new Image();
            image.size = url.openConnection().getContentLength();
            image.url = urlStr;
            //// TODO: 17/1/23 download image 
//            BufferedImage i = ImageIO.read(url);
        } catch (MalformedURLException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return image;
    }
}
