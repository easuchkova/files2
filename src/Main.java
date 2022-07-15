import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

        GameProgress firstGame = new GameProgress(1, 2, 3, 4.0);
        GameProgress secondGame = new GameProgress(2, 3, 4, 5.0);
        GameProgress thirdGame = new GameProgress(3, 4, 5, 6.0);

        try (FileOutputStream fos = new FileOutputStream("/Users/ekaterina/Games/savegames/firstGame.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(firstGame);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("/Users/ekaterina/Games/savegames/secondGame.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(secondGame);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("/Users/ekaterina/Games/savegames/thirdGame.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(thirdGame);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/Users/ekaterina/Games/savegames/zip_game_progress.zip"))) {
            FileInputStream fis = new FileInputStream("/Users/ekaterina/Games/savegames/firstGame.dat");
            ZipEntry entry = new ZipEntry("firstGame.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/Users/ekaterina/Games/savegames/zip_game_progress.zip"))) {
            FileInputStream fis = new FileInputStream("/Users/ekaterina/Games/savegames/secondGame.dat");
            ZipEntry entry = new ZipEntry("secondGame.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/Users/ekaterina/Games/savegames/zip_game_progress.zip"))) {
            FileInputStream fis = new FileInputStream("/Users/ekaterina/Games/savegames/thirdGame.dat");
            ZipEntry entry = new ZipEntry("thirdGame.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file1 = new File("/Users/ekaterina/Games/savegames/firstGame.dat");
        file1.delete();

        File file2 = new File("/Users/ekaterina/Games/savegames/secondGame.dat");
        file2.delete();

        File file3 = new File("/Users/ekaterina/Games/savegames/thirdGame.dat");
        file3.delete();

    }
}
