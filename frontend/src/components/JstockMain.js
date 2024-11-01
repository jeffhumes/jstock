import React, { useEffect, useState } from "react";
import axios from "axios";

const JstockMain = () => {
  const [text, setText] = useState();

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
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  }, []);

  return <div>{text}</div>;
};

export default JstockMain;
