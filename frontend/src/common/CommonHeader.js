import React, { useEffect, useState } from "react";

import {
  AppBar,
  IconButton,
  Toolbar,
  Typography,
  Button,
  Select,
  MenuItem,
} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import axios from "axios";

const CommonHeader = (props) => {
  const [exchangeCountryList, setExchangeCountryList] = useState([]);

  useEffect(() => {
    console.log("Entering UseEffect api/getExchangeCountryList");
    axios
      .get("/jstock/api/getExchangeCountryList")
      .then((response) => {
        console.log(response);
        setExchangeCountryList(response.data);
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  }, []);

  console.log("exchangeCountryList", exchangeCountryList);

  return (
    <AppBar position="static">
      <Toolbar>
        <IconButton
          sx={{ mr: 2 }}
          size="large"
          edge="start"
          color="inherit"
          aria-label="menu">
          {" "}
          <MenuIcon />
        </IconButton>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          {props.headerText}
        </Typography>

        <Select
          autoWidth="false"
          variant="outlined"
          id="marketSelect"
          size="small"
          // value={age}
          label="Select a Market"
          // onChange={handleChange}
        >
          {exchangeCountryList.map((item) => (
            <MenuItem key={item.id} value={item.exchangeCode}>
              {item.exchangeCode}
            </MenuItem>
          ))}
        </Select>

        <Button color="inherit">Login</Button>
      </Toolbar>
    </AppBar>
  );
};

export default CommonHeader;
