import React from "react";
import MarketStatus from "../finnHubComponents/MarketStatus";
import ChartMain from "../chartComponents/ChartMain";
import MarketStatusAgGrid from "../finnHubComponents/MarketStatusAgGrid";

const JstockMain = () => {
  return (
    <>
      <ChartMain></ChartMain>
      <MarketStatusAgGrid></MarketStatusAgGrid>
    </>
  );
};

export default JstockMain;
