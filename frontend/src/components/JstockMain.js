import React, { useEffect, useState } from "react";
import axios from "axios";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Chart } from "react-google-charts";
import _ from "lodash";

const JstockMain = () => {
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

  return (
    <>
      <h1>Markets Dashboard</h1>
      <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Exchange</TableCell>
              <TableCell>Holiday</TableCell>
              <TableCell>Is Market Open</TableCell>
              <TableCell>Session</TableCell>
              <TableCell>Current TimeStamp</TableCell>
              <TableCell>Time Zone</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {marketStatusList.map((item) => (
              <TableRow
                key={item.exchange}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}>
                <TableCell component="th" scope="row">
                  {item.exchange}
                </TableCell>
                <TableCell>{item.holiday ? "Yes" : "No"}</TableCell>
                <TableCell>
                  {item.isOpen ? "Market Open" : "Market Closed"}
                </TableCell>
                <TableCell>
                  {null === item.session
                    ? "Market Closed"
                    : _.capitalize(item.session)}
                </TableCell>
                <TableCell>{item.t}</TableCell>
                <TableCell>{item.timezone}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <br></br>
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

export default JstockMain;
