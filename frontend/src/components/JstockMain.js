import React, { useState, useEffect } from "react";
import MarketStatus from "../finnHubComponents/MarketStatus";
import ChartMain from "../chartComponents/ChartMain";
import MarketStatusAgGrid from "../finnHubComponents/MarketStatusAgGrid";
import CommonHeader from "../common/CommonHeader";
import axios from "axios";

const JstockMain = () => {
  const [funnhubConfig, setFinnHubConfig] = useState();

  useEffect(() => {
    console.log("Entering UseEffect finnhub/getFinnhubConfig");
    axios
      .get("/jstock/finnhub/getFinnhubConfig")
      .then((response) => {
        console.log(response);
        setFinnHubConfig(response.data);
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
      <CommonHeader headerText="My J-Stock Dashboard"></CommonHeader>
      {/* <ChartMain></ChartMain> */}
      <MarketStatusAgGrid></MarketStatusAgGrid>
    </>
  );
};

export default JstockMain;
