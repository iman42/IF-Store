import React from "react";
import "../styles/globals.css";
import { ThemeProvider, createTheme } from "@mui/material/styles";

const theme = createTheme();

// eslint-disable-next-line react/prop-types
function MyApp({ Component, pageProps }) {
    return <ThemeProvider theme={theme}><Component {...pageProps} /></ThemeProvider>;
}

export default MyApp;
