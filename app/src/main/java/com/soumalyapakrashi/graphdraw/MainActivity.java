package com.soumalyapakrashi.graphdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create the new graph
    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graph = findViewById(R.id.graph);
    }


    // Function to plot the graph
    public void plotGraph(View view) {
        // Get the EditText views
        EditText textX = findViewById(R.id.axisX);
        EditText textY = findViewById(R.id.axisY);

        // Get the strings entered
        String strX = textX.getText().toString() + " ";
        String strY = textY.getText().toString() + " ";

        // Create a new ArrayList
        ArrayList<Double> plotDataX = new ArrayList<>();
        ArrayList<Double> plotDataY = new ArrayList<>();

        // Add the X axis data to ArrayList
        for(int frontCount = 0, endCount = 0; frontCount < strX.length() - 1; endCount++) {
            // If a whitespace has been encountered
            if(strX.charAt(endCount) == ' ') {
                if(frontCount == endCount)   break;
                else {
                    plotDataX.add(Double.parseDouble(strX.substring(frontCount, endCount)));
                    frontCount = endCount + 1;
                }
            }
        }

        // Add the Y axis data to ArrayList
        for(int frontCount = 0, endCount = 0; frontCount < strY.length() - 1; endCount++) {
            // If a whitespace has been encountered
            if(strY.charAt(endCount) == ' ') {
                if(frontCount == endCount)   break;
                else {
                    plotDataY.add(Double.parseDouble(strY.substring(frontCount, endCount)));
                    frontCount = endCount + 1;
                }
            }
        }

        // Setup the new graph
        graph.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        for(int index = 0; index < plotDataX.size(); index++) {
            series.appendData(new DataPoint(plotDataX.get(index), plotDataY.get(index)), true, plotDataX.size());
        }

        // Set the viewport manually
        double maxX = series.getHighestValueX() + 1;
        double minX = series.getLowestValueX();
        if(minX != 0)   minX -= 1;
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(maxX);
        graph.getViewport().setMinX(minX);
        double maxY = series.getHighestValueY() + 1;
        double minY = series.getLowestValueY();
        if(minY != 0)   minY -= 1;
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(maxY);
        graph.getViewport().setMinY(minY);

        // Add the series to the graph
        graph.addSeries(series);
    }


    // Function to plot the graph
    public void scatterGraph(View view) {
        // Get the EditText views
        EditText textX = findViewById(R.id.axisX);
        EditText textY = findViewById(R.id.axisY);

        // Get the strings entered
        String strX = textX.getText().toString() + " ";
        String strY = textY.getText().toString() + " ";

        // Create a new ArrayList
        ArrayList<Double> plotDataX = new ArrayList<>();
        ArrayList<Double> plotDataY = new ArrayList<>();

        // Add the X axis data to ArrayList
        for(int frontCount = 0, endCount = 0; frontCount < strX.length() - 1; endCount++) {
            // If a whitespace has been encountered
            if(strX.charAt(endCount) == ' ') {
                if(frontCount == endCount)   break;
                else {
                    plotDataX.add(Double.parseDouble(strX.substring(frontCount, endCount)));
                    frontCount = endCount + 1;
                }
            }
        }

        // Add the Y axis data to ArrayList
        for(int frontCount = 0, endCount = 0; frontCount < strY.length() - 1; endCount++) {
            // If a whitespace has been encountered
            if(strY.charAt(endCount) == ' ') {
                if(frontCount == endCount)   break;
                else {
                    plotDataY.add(Double.parseDouble(strY.substring(frontCount, endCount)));
                    frontCount = endCount + 1;
                }
            }
        }

        // Setup the new graph
        graph.removeAllSeries();
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>();
        series.setSize(6);

        for(int index = 0; index < plotDataX.size(); index++) {
            series.appendData(new DataPoint(plotDataX.get(index), plotDataY.get(index)), true, plotDataX.size());
        }

        // Set the viewport manually
        double maxX = series.getHighestValueX() + 1;
        double minX = series.getLowestValueX();
        if(minX != 0)   minX -= 1;
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(maxX);
        graph.getViewport().setMinX(minX);
        double maxY = series.getHighestValueY() + 1;
        double minY = series.getLowestValueY();
        if(minY != 0)   minY -= 1;
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(maxY);
        graph.getViewport().setMinY(minY);

        // Add the series to the graph
        graph.addSeries(series);
    }
}
