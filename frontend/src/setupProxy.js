const { createProxyMiddleware } = require("http-proxy-middleware");

const defaultContextPath = "/jstock";

const proxyPaths = ["/api", "/finnhub"];

const contextProxyPaths = proxyPaths.map(function (path) {
  return [defaultContextPath, path].join("");
});

module.exports = function (app) {
  app.use(
    createProxyMiddleware(contextProxyPaths, {
      target: "http://localhost:8081",
      changeOrigin: true,
    })
  );
};
