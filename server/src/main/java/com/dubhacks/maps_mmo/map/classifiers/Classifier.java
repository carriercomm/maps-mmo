package com.dubhacks.maps_mmo.map.classifiers;

import com.dubhacks.maps_mmo.map.GeoJsonFileType;
import com.dubhacks.maps_mmo.map.MinMaxLngLat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class Classifier {
    public abstract GeoJsonFileType getType();

    public abstract void classify(MinMaxLngLat mm, List<Feature> features);

    public void classifyFiles(MinMaxLngLat mm, List<File> files) throws IOException {
        for (File file : files) {
            FeatureCollection collection = new ObjectMapper().readValue(file, FeatureCollection.class);
            this.classify(mm, collection.getFeatures());
        }
    }
}