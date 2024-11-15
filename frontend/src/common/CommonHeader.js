import * as React from "react";

import { AppBar, IconButton, Toolbar, Typography, Button } from "@mui/material";
// import Toolbar from "@mui/material/Toolbar";
// import Typography from "@mui/material/Typography";
// import Button from "@mui/material/Button";
// import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";

const CommonHeader = (props) => {
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
        <Button color="inherit">Login</Button>
      </Toolbar>
    </AppBar>
  );
};

export default CommonHeader;
