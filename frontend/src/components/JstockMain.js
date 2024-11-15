import React from "react";
import MarketStatus from "../finnHubComponents/MarketStatus";
import ChartMain from "../chartComponents/ChartMain";
import MarketStatusAgGrid from "../finnHubComponents/MarketStatusAgGrid";
import CommonHeader from "../common/CommonHeader";

const JstockMain = () => {
  return (
    <>
      <CommonHeader headerText="My J-Stock Dashboard"></CommonHeader>
      {/* <ChartMain></ChartMain> */}
      <MarketStatusAgGrid></MarketStatusAgGrid>
    </>
  );
};

export default JstockMain;
