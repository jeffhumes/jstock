import React, { useState, useEffect, useCallback } from "react";
import MarketStatus from "../finnHubComponents/MarketStatus";
import ChartMain from "../chartComponents/ChartMain";
import MarketStatusAgGrid from "../finnHubComponents/MarketStatusAgGrid";
import CommonHeader from "../common/CommonHeader";
import axios from "axios";

const JstockMain = () => {
  const [finnhubConfig, setFinnHubConfig] = useState();
  const [finnhubConfigIsPaid, setFinnHubConfigIsPaid] = useState();
  const [selectedExchangeCode, setSelectedExchangeCode] = useState();

  useEffect(() => {
    console.log("Entering UseEffect finnhub/getFinnhubConfigIsPaid");
    axios
      .get("/jstock/finnhub/getFinnhubConfigIsPaid")
      .then((response) => {
        // console.log("Is Paid Finnhub Subscription?: ", response.data);
        setFinnHubConfigIsPaid(response.data);
      })
      .catch((error) => {
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  }, []);

  const handleExchangeCodeSelection = useCallback(
    (e) => {
      console.log("entering handleExchangeCodeSelection", e);
      setSelectedExchangeCode(e.target);
    },
    [setSelectedExchangeCode]
  );

  return (
    <>
      <CommonHeader
        headerText="My J-Stock Dashboard"
        finnhubConfigIsPaid={finnhubConfigIsPaid}
        handleExchangeCodeSelection={
          handleExchangeCodeSelection
        }></CommonHeader>
      {/* <ChartMain></ChartMain> */}
      <MarketStatusAgGrid
        selectedExchangeCode={selectedExchangeCode}
        handleExchangeCodeSelection={
          handleExchangeCodeSelection
        }></MarketStatusAgGrid>
    </>
  );
};

export default JstockMain;
