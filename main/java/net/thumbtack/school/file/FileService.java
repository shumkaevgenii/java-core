package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingErrorCode;
import net.thumbtack.school.ttschool.TrainingException;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.io.*;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] array = new byte[fis.available()];
            fis.read(array);
            return array;
        }
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] byteArrayOutput;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream(array.length)) {
            out.write(array);
            byteArrayOutput = out.toByteArray();
        }
        try (ByteArrayInputStream in = new ByteArrayInputStream(byteArrayOutput)) {
            byte[] byteArrayInput = new byte[byteArrayOutput.length % 2 == 0 ? byteArrayOutput.length / 2 : byteArrayOutput.length / 2 + 1];
            for (int i = 0, off = 0; i < byteArrayOutput.length; i+=2) {
                in.read(byteArrayInput, off++,1);
                in.skip(1);
            }
            return byteArrayInput;
        }
    }


    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] array = new byte[in.available()];
            in.read(array);
            return array;
        }
    }

    public static void writeRectButtonToBinaryFile(File file, RectButton rectButton) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            out.writeInt(rectButton.getTopLeft().getX());
            out.writeInt(rectButton.getTopLeft().getY());
            out.writeInt(rectButton.getBottomRight().getX());
            out.writeInt(rectButton.getBottomRight().getY());
            out.writeUTF(rectButton.getState().toString());
            out.writeUTF(rectButton.getText());
        }
    }

    public static RectButton readRectButtonFromBinaryFile(File file) throws IOException, WindowException {
        try (DataInputStream din = new DataInputStream(new FileInputStream(file))) {
            Point topLeft = new Point(din.readInt(), din.readInt());
            Point bottomRight = new Point(din.readInt(), din.readInt());
            WindowState State = WindowState.fromString(din.readUTF());
            String Text = din.readUTF();
            return new RectButton(topLeft, bottomRight, State, Text);
        }
    }

    public static void writeRectButtonArrayToBinaryFile(File file, RectButton[] rects) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            for (RectButton r : rects) {
                out.writeInt(r.getTopLeft().getX());
                out.writeInt(r.getTopLeft().getY());
                out.writeInt(r.getBottomRight().getX());
                out.writeInt(r.getBottomRight().getY());
            }
        }
    }

    public static void modifyRectButtonArrayInBinaryFile(File file) throws IOException {
        try (RandomAccessFile iof = new RandomAccessFile(file, "rw")) {
            int x;
            while (iof.getFilePointer() < iof.length() - 1) {
                x = iof.readInt(); // Читаем значение х
                iof.seek(iof.getFilePointer() - 4); //Возвращаемся назад на 4 байта для записи нового х
                iof.writeInt(++x); // Записываем новый х
                iof.readInt(); // Пропускаем 4 байта, то есть y

                x = iof.readInt();// Читаем значение х
                iof.seek(iof.getFilePointer() - 4); //Возвращаемся назад на 4 байта для записи нового х
                iof.writeInt(++x);// Записываем новый х
                iof.readInt(); // Пропускаем 4 байта, то есть y
            }
        }
    }

    public static RectButton[] readRectButtonArrayFromBinaryFile(File file) throws IOException, WindowException {
        try (DataInputStream din = new DataInputStream(new FileInputStream(file))) {
            int numOfButtons = (int)file.length() / 16;
            RectButton[] rectButtons = new RectButton[numOfButtons];

            for (int i = 0; i < numOfButtons; i++) {
                rectButtons[i] = new RectButton(new Point(din.readInt(), din.readInt()),
                                                new Point(din.readInt(), din.readInt()),
                                                   WindowState.ACTIVE, "OK");
            }
            return rectButtons;
        }
    }

    public static void writeRectButtonToTextFileOneLine(File file, RectButton rectButton) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            out.write(rectButton.getTopLeft().getX() + " " +
                          rectButton.getTopLeft().getY() + " " +
                          rectButton.getBottomRight().getX() + " " +
                          rectButton.getBottomRight().getY() + " " +
                          rectButton.getState().toString() + " " +
                          rectButton.getText());
            out.newLine();
        }
    }

    public static RectButton  readRectButtonFromTextFileOneLine(File file) throws IOException, WindowException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String[] data = in.readLine().split(" ");
            Point topLeft = new Point(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
            Point bottomRight = new Point(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            WindowState State = WindowState.fromString(data[4]);
            String Text = data[5];
            return new RectButton(topLeft, bottomRight, State, Text);
        }
    }

    public static void  writeRectButtonToTextFileSixLines(File file, RectButton rectButton) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            out.write(rectButton.getTopLeft().getX() + "\n" +
                    rectButton.getTopLeft().getY() + "\n" +
                    rectButton.getBottomRight().getX() + "\n" +
                    rectButton.getBottomRight().getY() + "\n" +
                    rectButton.getState().toString() + "\n" +
                    rectButton.getText());
        }
    }

    public static RectButton  readRectButtonFromTextFileSixLines(File file) throws IOException,  WindowException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            Point topLeft = new Point(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
            Point bottomRight = new Point(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
            WindowState State = WindowState.fromString(in.readLine());
            String Text = in.readLine();
            return new RectButton(topLeft, bottomRight, State, Text);
        }
    }

    public static void  writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try(PrintStream out = new PrintStream(file, "UTF-8")){
            out.print(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        }
    }

    public static Trainee  readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String[] data = in.readLine().split(" ");
            return new Trainee(data[0], data[1], Integer.parseInt(data[2]));
        }
    }

    public static void  writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try(PrintStream out = new PrintStream(file, "UTF-8")){
            out.println(trainee.getFirstName());
            out.println(trainee.getLastName());
            out.print(trainee.getRating());
        }
    }

    public static Trainee  readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            return new Trainee(in.readLine(),in.readLine(),Integer.parseInt(in.readLine()));
        }
    }

    public static void  serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(trainee);
        }
    }

    public static Trainee  deserializeTraineeFromBinaryFile(File file)  throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) in.readObject();
        }
    }

    public static String  serializeTraineeToJsonString(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee  deserializeTraineeFromJsonString(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void  serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file))){
            Gson gson = new Gson();
            gson.toJson(trainee,out);
        }
    }

    public static Trainee  deserializeTraineeFromJsonFile(File file) throws IOException  {
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            Gson gson = new Gson();
            return gson.fromJson(in,Trainee.class);
        }
    }
}
