import React, { useState, useEffect, useMemo } from "react";
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

  const PriceCellRenderer = (props) => {
    return (
      <>
        <button
          onClick={() => {
            window.alert("YO!" + props.value);
          }}>
          +
        </button>
        {props.value}
      </>
    );
  };

  const defaultColDef = useMemo(() => {
    return { flex: 1, filter: true, floatingFilter: true };
  });

  const [rowData, setRowData] = useState([
    { vehicleMake: "Tesla", model: "Model Y", price: 64950, electric: true },
    { vehicleMake: "Ford", model: "Mustang GT", price: 33490, electric: false },
    { vehicleMake: "Toyota", model: "Corolla", price: 29500, electric: false },
  ]);

  const [colDefs, setColDefs] = useState([
    {
      field: "vehicleMake",
      // headerName: "Company",
      // valueGetter: (value) => value.data.vehicleMake + " / " + value.data.price,
    },
    { field: "model" },
    {
      field: "price",
      valueGetter: (value) => "$" + value.data.price.toLocaleString(),
      cellRenderer: PriceCellRenderer,
    },
    { field: "electric" },
  ]);

  return colDefs && rowData ? (
    <div className="ag-theme-quartz" style={{ height: 500 }}>
      <AgGridReact
        defaultColDef={defaultColDef}
        columnDefs={colDefs}
        rowData={rowData}></AgGridReact>
    </div>
  ) : null;
};

export default MarketStatusAgGrid;
