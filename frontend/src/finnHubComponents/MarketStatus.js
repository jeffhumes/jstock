import React, { useState, useEffect } from "react";
import axios from "axios";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import _ from "lodash";

const MarketStatus = () => {
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
  );
};

export default MarketStatus;
