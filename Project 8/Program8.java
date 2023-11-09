/* Rhodes Ferris
   Program 8
   Main Function
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program8 {
    public static void main(String[] args) {
        BST dracula = new BST();

        try (BufferedReader reader = new BufferedReader(new FileReader("dracula.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    dracula.insert(word);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't read this file." + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("analysis.txt"))) {
            int nodeCount = dracula.countNodes(dracula.getRoot());
            int treeHeight = dracula.height(dracula.getRoot());
            int maxPossibleNodes = dracula.maxNodes(treeHeight);

            writer.write("Rhodes Ferris" + '\n' + "Program 8 BST Analysis");
            writer.write('\n' + "Number of nodes: " + nodeCount);
            writer.write('\n' + "Tree height: " + treeHeight);
            writer.write('\n' + "Max possible nodes: " + maxPossibleNodes);
        } catch (IOException e) {
            System.out.println("Can't write to this file");
        }

    }
}