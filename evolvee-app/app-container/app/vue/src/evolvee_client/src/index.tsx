//@ts-nocheck
import React from 'react';
import { hydrate, render } from "react-dom";
import EvolveeUI from './ui/EvolveeUI';

const rootElement = document.getElementById("root");
if (rootElement != null && rootElement.hasChildNodes()) {
  hydrate(<EvolveeUI />, rootElement);
} else {
  render(<EvolveeUI />, rootElement);
}
