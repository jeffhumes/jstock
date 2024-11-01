import React, { useEffect, useState } from "react";
import axios from "axios";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

const JstockMain = () => {
  const [text, setText] = useState();
  const [textList, setTextList] = useState([]);

  useEffect(() => {
    console.log("Entering UseEffect getString");
    axios
      .get("/jstock/api/getString")
      .then((response) => {
        setText(response.data);
      })
      .catch(function (error) {
        console.log(error);
      })
      .finally(function () {
        // always executed
      });
  }, []);

  useEffect(() => {
    console.log("Entering UseEffect getStringFromDatabase");
    axios
      .get("/jstock/api/getStringFromDatabase")
      .then((response) => {
        console.log(response);
        setTextList(response.data);
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
      <div>{text}</div>
      <br></br>

      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Name</TableCell>
              <TableCell>Text</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {textList.map((item) => (
              <TableRow
                key={item.stringName}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}>
                <TableCell component="th" scope="row">
                  {item.stringName}
                </TableCell>
                <TableCell>{item.stringText}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default JstockMain;
