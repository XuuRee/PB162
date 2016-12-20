/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

/**
 * Class storing polygons via map
 * 
 * @author Filip Valcháø
 * @version 2016 12 05
 */
public class LabeledPolygon extends SimplePolygon implements PolygonIO {
    
    private final Map<String,Vertex2D> map = new TreeMap<>();

    /**
     * Add vertex to polygon
     * 
     * @param label given identification of vertex
     * @param vert given Vertex2D
     * @throws IllegalArgumentException is thrown if vert or label is null 
     */
    public void addVertex(String label, Vertex2D vert) throws IllegalArgumentException {
        if(vert == null) { 
            throw new IllegalArgumentException("Vertex2D is null !");
        }
        
        if(label == null) {
            throw new IllegalArgumentException("String is null !");
        }
        
        map.put(label,vert);
    }
    
    /**
     * Returns vertex by label key
     * 
     * @param label given identification of vertex
     * @return Vertex2D
     * @throws IllegalArgumentException is thrown if label does not exist 
     */
    public Vertex2D getVertex(String label) throws IllegalArgumentException {
        if(!map.containsKey(label)) {
            throw new IllegalArgumentException("Label does not exist !");
        }
       
        return map.get(label);
    }
    
    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if(index < 0) { 
            throw new IllegalArgumentException("Index is below zero!");
        }
        
        List<Vertex2D> ordered = new ArrayList<>(map.values());
        return ordered.get(index % getNumVertices());
        
    }

    @Override
    public int getNumVertices() {
        return map.size();
    }
    
    /**
     * Collections of labels, keys
     * 
     * @return keys 
     */
    public Collection<String> getLabels() {
        return Collections.unmodifiableCollection(map.keySet());
    }
    
    /**
     * Return collection of labels that are with specified vertex
     * 
     * @param vert vertex to find labels
     * @return keys
     */
    public Collection<String> getLabels(Vertex2D vert) {
        Set<String> keys = new HashSet<>();
        
        for(String i: map.keySet()) {
            if(map.get(i).equals(vert)) {
                keys.add(i);
            }
        }
        
        return keys;    
    }
    
    /**
     * Find duplicate vertices
     * 
     * @return duplicate vertices 
     */
    public Collection<Vertex2D> duplicateVertices() {
        Set<Vertex2D> values = new HashSet<>();
        Set<Vertex2D> duplicateValues = new HashSet<>();
        
        for(Vertex2D elementList : map.values()) {
            if(!values.add(elementList)) {
                duplicateValues.add(elementList);
            }
        }
        
        return duplicateValues;
    }
    
    /**
     * Returns vertices in natural order
     * 
     * @return natural sorted vertices 
     */
    public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<>(map.values());
    }
       
    /**
     * Returns vertices in order to specified comparator
     * 
     * @param vertex vertex
     * @return sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> vertex) {
       SortedSet<Vertex2D> values = new TreeSet<>(vertex);
       values.addAll(map.values());
       return values;
    }
    
    @Override
    public void read(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        Map<String,Vertex2D> temp = new TreeMap<>();
        
        String line = br.readLine();
        
        while(line != null) {
            String[] data = line.split(" ", 3);
            if(data.length != 3) {
                throw new IOException("Input is not correct");
            }
            try {
                String label = data[2];
                double x = Double.valueOf(data[0]); // parseDouble
                double y = Double.valueOf(data[1]);
                temp.put(label, new Vertex2D(x,y));
            } catch(NumberFormatException e) {
                throw new IOException("Input is not correct",e);
            }
            line = br.readLine();
        }
        
        map.putAll(temp);
    }
    
    @Override
    public void read(File file) throws IOException {
        try (FileInputStream is = new FileInputStream(file)) {
            read(is);
        }
    }
    
    @Override
    public void write(File file) throws IOException {
        try (FileOutputStream os = new FileOutputStream(file)) {
            write(os);
        }
    }
    
    @Override
    public void write(OutputStream os) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "utf-8"));
        Iterator<Map.Entry<String,Vertex2D>> entries = map.entrySet().iterator();
        
        while(entries.hasNext()) {
             Map.Entry<String,Vertex2D> entry = entries.next();
             Vertex2D vertex = getVertex(entry.getKey());
             writer.write(vertex.getX() + " " + vertex.getY() + " " + entry.getKey());
             writer.newLine();
        }
        
        writer.flush();
    }

}
