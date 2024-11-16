import React, { useState, useEffect } from "react";
import MarketStatus from "../finnHubComponents/MarketStatus";
import ChartMain from "../chartComponents/ChartMain";
import MarketStatusAgGrid from "../finnHubComponents/MarketStatusAgGrid";
import CommonHeader from "../common/CommonHeader";
import axios from "axios";

const JstockMain = () => {
  const [finnhubConfig, setFinnHubConfig] = useState();
  const [finnhubConfigIsPaid, setFinnHubConfigIsPaid] = useState();

  useEffect(() => {
    console.log("Entering UseEffect finnhub/getFinnhubConfigIsPaid");
    axios
      .get("/jstock/finnhub/getFinnhubConfigIsPaid")
      .then((response) => {
        console.log("Is Paid Finnhub Subscription?: ", response.data);
        setFinnHubConfigIsPaid(response.data);
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
      <CommonHeader
        headerText="My J-Stock Dashboard"
        finnhubConfigIsPaid={finnhubConfigIsPaid}></CommonHeader>
      {/* <ChartMain></ChartMain> */}
      <MarketStatusAgGrid></MarketStatusAgGrid>
    </>
  );
};

export default JstockMain;
