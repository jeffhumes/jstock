import React from "react";
import { Chart } from "react-google-charts";

const ChartMain = () => {
  return (
    <>
      <h1>Markets Dashboard</h1>

      <Chart
        chartType="ScatterChart"
        data={[
          ["Age", "Weight"],
          [4, 5.5],
          [8, 12],
        ]}
        width="100%"
        height="400px"
        legendToggle
      />
      <br></br>
      <Chart
        chartType="CandlestickChart"
        data={[
          ["day", "a", "b", "c", "d"],
          ["Mon", 20, 28, 38, 88],
          ["Tue", 31, 38, 55, 66],
          ["Wed", 50, 55, 77, 80],
          ["Thu", 50, 77, 66, 77],
          ["Fri", 15, 66, 22, 68],
        ]}
        // width="100%"
        // height="400px"
        // legendToggle
      />
    </>
  );
};

export default ChartMain;
