import * as React from 'react';
import { Component } from 'react';
import Logo from './Logo';
import Credits from './Credits';
import './splash.css';
import Draggable from 'react-draggable';

const initialState = {
  // @ts-ignore
    looks: [],
    looksLoaded: 0,
};

type GenericUIProps = {};
type GenericUIState = {};
class GenericSplash extends Component<GenericUIProps, GenericUIState> {
  
    constructor(props: GenericUIProps) {
    super(props);
    this.state = initialState;
  }
    
  render() {
    return (
        // @ts-ignore
        <Draggable handle=".logo">
          <div className="main_container">
            <div className="main_content">
              <button className="close">X</button>
              <Logo />
              <hr />
              {this.props.children}
            </div>
            <Credits />
          </div>
        </Draggable>
    );
  }
}

export default GenericSplash;
