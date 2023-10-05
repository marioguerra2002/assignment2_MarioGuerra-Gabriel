package src.Exercise7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanTree {

    private HuffmanNode root;


    public HuffmanNode createHuffmanTree(HuffmanNode[] nodes){
        
        



    }

    public static void main(String [] args) throws IOException {

        String pathToFile = args[0];

        Map<Character, Integer> caracterFrecuency = new HashMap<>();
        BufferedReader reading = new BufferedReader(new FileReader(pathToFile));
        int c;

        while ((c = reading.read()) != -1) {
            char caracter = (char) c;
            if (caracterFrecuency.containsKey(caracter)) {
                caracterFrecuency.put(caracter, caracterFrecuency.get(caracter) + 1);
            } else {
                caracterFrecuency.put(caracter, 1);
            }
        }

        HuffmanNode[] nodesTree = new HuffmanNode[caracterFrecuency.size()];
        int index = 0;

        for (Map.Entry<Character, Integer> value : caracterFrecuency.entrySet()) {
            char caracter = value.getKey();
            int frecuency = value.getValue();

            HuffmanNode nodo = new HuffmanNode(caracter, frecuency);
            nodesTree[index++] = nodo;
        }

        HuffmanTree huffmanTree = new HuffmanTree();

        huffmanTree.createHuffmanTree(nodesTree);

    }

}
