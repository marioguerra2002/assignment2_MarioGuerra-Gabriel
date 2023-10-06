package src.Exercise7;

import java.io.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// import java.util.Comparator;
// import java.util.Arrays;

public class HuffmanTree {

    private HuffmanNode root;


    public HuffmanNode createHuffmanTree(HuffmanNode[] nodes){
        HuffmanNode[] auxiliar = null;
        while (nodes.length > 1) {  // nodes are going to be merged until there is one node left
            // sort the nodes from lowest to highest
            sortNodes(nodes);
            // create a new node with the sum of the two lowest nodes
            // // // char key = (char) (nodes[0].getKey() + nodes[1].getKey());  // sum of the two lowest nodes keys
            HuffmanNode newNode = new HuffmanNode((char) (nodes[0].getKey() + nodes[1].getKey()),(nodes[0].getFrecuency() + nodes[1].getFrecuency()));
            // set the two lowest nodes as the left and right children of the new node
            newNode.setLeftChild(nodes[0]);
            newNode.setRightChild(nodes[1]);
            // remove the two lowest nodes from the array ([0],[1])
            auxiliar = new HuffmanNode[nodes.length - 2];
            for (int i = 2; i < nodes.length; i++) {
                auxiliar[i - 2] = nodes[i];
            }
            nodes = auxiliar; // update the array without the two lowest nodes
            // add the new node to the array
            auxiliar = new HuffmanNode[nodes.length + 1];
            auxiliar[0] = newNode;
            for (int i = 0; i < nodes.length; i++) {
                auxiliar[i + 1] = nodes[i];
            }
            nodes = auxiliar; // update the array with the new node
        }

        // comentario para gabri: una vez que se termina el while, queda un solo nodo en el array, que es el root, del cual colgaran todos los hijos
        // no lo he podido ejecuctar pero deberia de funcionar. Lo que faltaría sería la asigancion de codigo 
        // (0 izquierda, 1 derecha (no estoy seguro de esto ni se por que se tiene que hacer estio y no la codificacion direcatmente))) 
        // y la codificacion de cada caracter. Luego por ultimo, un método que permita devolver el codigo Huffman de un caracter en especifico del arbol creo
        
        // si lo del codigo 0 y 1 es necesario, habría que añadir otro atritubo, el de coding 
        root = nodes[0];
        return root;
    }
    public void CodingAssigantion(HuffmanNode root) {

    }
    public void sortNodes(HuffmanNode[] nodes) {
        
        // // // // // // Arrays.sort(nodes, new Comparator<HuffmanNode>() {
        // // // // // //     @Override 
        // // // // // //     public int compare(HuffmanNode o1, HuffmanNode o2) {
        // // // // // //         return o1.getFrecuency() - o2.getFrecuency();
        // // // // // //     }
        // // // // // // });
        /////////////////// alternativa de internet ///////////////////////
        HuffmanNode aux = null;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length - 1; j++) { // j - 1 because last node its already sorted
                if (nodes[j].getFrecuency() > nodes[j + 1].getFrecuency()) {
                    aux = nodes[j]; 
                    nodes[j] = nodes[j + 1];
                    nodes[j + 1] = aux;
                }
            }
        } 
    }

    public static void main(String [] args) throws IOException {

        String pathToFile = args[0];

        Map<Character, Integer> caracterFrecuency = new HashMap<>();
        BufferedReader reading = new BufferedReader(new FileReader(pathToFile));
        int character; // variable to read the file character by character

        while ((character = reading.read()) != -1) {
            char caracter = (char) character;
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
