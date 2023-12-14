import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        challengeOne("testInputOneTwo.txt");
        challengeTwo("testInputOneTwo.txt");
        challengeOne("inputOneTwo.txt");
        challengeTwo("inputOneTwo.txt");
        challengeThree("testInputThreeFour.txt");
        challengeFour("testInputThreeFour.txt");
        challengeThree("inputThreeFour.txt");
        challengeFour("inputThreeFour.txt");
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int largercount = 0;
        int [] rs = new int[countLinesInFile(fileName)];
        rs = readFile(fileName);
        for (int i = 0; i<rs.length-1; i++) {
            if (rs[i] < rs[i+1]) {
                largercount++;
            }
        }
        System.out.println(largercount);
        return largercount;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int largercount = 0;
        int [] rs = new int[countLinesInFile(fileName)];
        rs = readFile(fileName);
        for (int i = 0; i<rs.length-3; i++) {
            if (rs[i] < rs[i+3]) {
                largercount++;
            }
        }
        System.out.println(largercount);
        return largercount;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    private static int challengeThree(String fileName) throws FileNotFoundException {
        int[] data = readFileTwo(fileName);
        int forward = 0;
        int updown = 0;
        for (int value : data) {
            int direction = value / 10;
            int magnitude = value % 10;

            switch (direction) {
                case 1:
                    updown += magnitude;
                    break;
                case 2:
                    updown -= magnitude;
                    break;
                case 3:
                    forward += magnitude;
                    break;
                default:
                    break;
            }
        }
        int finalHorizontalPosition = forward;
        int finalDepth = updown;
        System.out.println(finalHorizontalPosition * finalDepth);
        return finalHorizontalPosition * finalDepth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    private static int challengeFour(String filename) throws FileNotFoundException {
        int[] Data = readFileTwo(filename);
        int forward = 0;
        int updown = 0;
        int aim = 0;
        for (int value : Data) {
            int direction = value / 10;
            int magnitude = value % 10;

            switch (direction) {
                case 1:
                    aim -= magnitude;
                    break;
                case 2:
                    aim += magnitude;
                    break;
                case 3:
                    forward += magnitude;
                    updown += aim * magnitude;
                    break;
                default:
                    break;
            }
        }

        int finalHorizontalPosition = forward;
        int finalDepth = updown;
        System.out.println(finalHorizontalPosition * finalDepth);
        return finalHorizontalPosition * finalDepth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static int[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                int directionValue = getDirectionValue(parts[0]);
                int value = Integer.parseInt(parts[1]);
                int combinedValue = directionValue * 10 + value;
                data[index++] = combinedValue;
            }
        }
        scanner.close();
        return data;
    }

    private static int getDirectionValue(String direction) {
        switch (direction) {
            case "down":
                return 2;
            case "up":
                return 1;
            case "forward":
                return 3;
            default:
                return 0;
        }
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}