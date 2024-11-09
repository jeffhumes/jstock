import React, { useState, useEffect, useMemo, useCallback } from "react";
import axios from "axios";
import _ from "lodash";
import { AgGridReact } from "ag-grid-react";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
import "../common/css/AgGridCustomization.css";
import { Button } from "@mui/material";

const MarketStatusAgGrid = () => {
  const [marketStatusList, setMarketStatusList] = useState([]);
  const [rowData, setRowData] = useState([]);

  const defaultColDef = useMemo(() => {
    return { flex: 1, filter: true, floatingFilter: false };
  });

  const [colDefs, setColDefs] = useState([
    { field: "exchange" },
    { field: "holiday", headerName: "Holiday" },
    {
      field: "isOpen",
      headerName: "Open",
      valueFormatter: (p) => (p.value === "true" ? "Yes" : "No"),
      cellClassRules: {
        "green-cell": (p) => p.value === "true",
        "red-cell": (p) => p.value === "false",
      },
    },
    { field: "session" },
    { field: "t" },
    { field: "timezone" },
  ]);

  let marketStatusObject = {
    exchange: null,
    holiday: null,
    isOpen: null,
    session: null,
    t: null,
    timezone: null,
  };

  const PopulateMarketStatus = useCallback((props) => {
    console.log("PopulateMarketStatus props", props);
    const tempArray = [];
    props.data.map((marketInfo) => {
      console.log(marketInfo);
      console.log("tempArray before: ", tempArray);
      let tempObject = {
        exchange: marketInfo.exchange,
        holiday: marketInfo.holiday,
        isOpen: marketInfo.isOpen,
        session: marketInfo.session,
        t: marketInfo.t,
        timezone: marketInfo.timezone,
      };
      tempArray.push(tempObject);
      console.log("tempArray after: ", tempArray);
    });
    // let obj = Object.fromEntries(arr);
    setRowData(tempArray);
  });

  console.log("rowData", rowData);

  useEffect(() => {
    console.log("Entering UseEffect finnhub/getMarketStatus");
    axios
      .get("/jstock/finnhub/getMarketStatus")
      .then((response) => {
        console.log(response);
        response.data
          ? PopulateMarketStatus({ data: response.data })
          : console.log("Error processing market status information");
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  }, []);

  const handleButtonClick = useCallback(() => {
    console.log("Entering useCallback finnhub/getMarketHolidays");
    axios
      .get("/jstock/finnhub/getMarketHolidays")
      .then((response) => {
        console.log(response);
        // response.data
        //   ? PopulateMarketStatus({ data: response.data })
        //   : console.log("Error processing market status information");
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  }, []);

  // useEffect(() => {
  //   console.log("Entering UseEffect finnhub/getMarketHolidays");
  //   axios
  //     .get("/jstock/finnhub/getMarketHolidays")
  //     .then((response) => {
  //       console.log(response);
  //       // response.data
  //       //   ? PopulateMarketStatus({ data: response.data })
  //       //   : console.log("Error processing market status information");
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     })
  //     .finally(() => {
  //       // always executed
  //     });
  // }, []);

  return colDefs && rowData ? (
    <>
      <div className="ag-theme-quartz" style={{ height: 500 }}>
        <AgGridReact
          defaultColDef={defaultColDef}
          columnDefs={colDefs}
          rowData={rowData}></AgGridReact>
      </div>
      <div>
        {" "}
        <Button onClick={handleButtonClick}>sadfasdf</Button>
      </div>
    </>
  ) : null;
};

export default MarketStatusAgGrid;
