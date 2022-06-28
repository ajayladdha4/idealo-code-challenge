import React from 'react';
import { shallow, render, mount, configure } from 'enzyme';
import Square from './Square';

import Adapter from 'enzyme-adapter-react-16';
import jsdom from 'jsdom';  
const {JSDOM} = jsdom;  
const {document} = (new JSDOM('<!doctype html><html><body></body></html>')).window;  
global.document = document;  
global.window = document.defaultView;

configure({adapter: new Adapter()});
describe('Square', () => {
  let props = {
    direction : "EAST",
    value : ">"
  };
  let renderedSquare;

  

  const renderTestComponent = () => {
    if (!renderedSquare) {
      renderedSquare = render(<Square {...props} />);
    }
    return renderedSquare;
  };

  beforeEach(() => {
    // props = {};
    renderedSquare = undefined;
  });

  // Shallow / unit tests begin here
  test('Square render with default props',()=>{
    renderTestComponent();
  })

  // Render / mount / integration tests begin here
  
});
