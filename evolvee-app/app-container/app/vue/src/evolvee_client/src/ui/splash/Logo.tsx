import React from 'react';
import './logo.css';

class Logo extends React.Component {
    render() {
        return (
            <div className="logo">
                <div>
                    <img src="images/bottom_bar/ghosthead.png" alt="evolvee" />
                    <h1>evolvee</h1>
                </div>
            </div>
        );
    }
}

export default Logo;