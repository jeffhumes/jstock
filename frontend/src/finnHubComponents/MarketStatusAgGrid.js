import React, { useState, useEffect } from "react";
import axios from "axios";
import _ from "lodash";
import { AgGridReact } from "ag-grid-react";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
import "../common/css/AgGridCustomization.css";

const MarketStatusAgGrid = () => {
  const [marketStatusList, setMarketStatusList] = useState([]);

  useEffect(() => {
    console.log("Entering UseEffect finnhub/getMarketStatus");
    axios
      .get("/jstock/finnhub/getMarketStatus")
      .then((response) => {
        console.log(response);
        setMarketStatusList(response.data);
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  }, []);

  const [rowData, setRowData] = useState([
    { make: "Tesla", model: "Model Y", price: 64950, electric: true },
    { make: "Ford", model: "Mustang GT", price: 33490, electric: false },
    { make: "Toyota", model: "Corolla", price: 29500, electric: false },
  ]);

  const [colDefs, setColDefs] = useState([
    { field: "make" },
    { field: "model" },
    { field: "price" },
    { field: "electric" },
  ]);

  return colDefs && rowData ? (
    <div className="ag-theme-quartz" style={{ height: 500 }}>
      <AgGridReact columnDefs={colDefs} rowData={rowData}></AgGridReact>
    </div>
  ) : null;
};

export default MarketStatusAgGrid;
