package com.dubhacks.maps_mmo.map.renderers;

import com.dubhacks.maps_mmo.map.GameMap;
import com.dubhacks.maps_mmo.map.GeoJsonFileType;
import org.geojson.Feature;
import org.geojson.GeoJsonObject;
import org.geojson.LineString;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class RoadRenderer extends Renderer {
    public RoadRenderer(GameMap map) {
        super(map);
    }

    @Override
    public void render(List<Feature> features) throws IOException {
        BufferedImage image = this.allocateImage();

        for (Feature road : features) {
            GeoJsonObject geometry = road.getGeometry();
            if (geometry instanceof LineString) {
                this.draw((LineString) geometry, image);
            }
        }

        this.write(image);
    }

    @Override
    public GeoJsonFileType getFileType() {
        return GeoJsonFileType.ROADS;
    }
}
