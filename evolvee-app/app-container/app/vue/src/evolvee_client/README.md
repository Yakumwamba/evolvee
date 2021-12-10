# [evolvee.io](https://evolvee.io/) client &middot; [![GitHub license](https://img.shields.io/badge/license-GNU-blue.svg)](https://github.com/josedn/evolvee_client/blob/master/LICENSE) 
![evolvee](https://i.imgur.com/wGITX22.png)

Habbo Hotel (r60+) remake made with modern (as 2019) technologies.
This repo features a TypeScript/PixiJS/React Habbo Hotel client remake.
## Features:
* Built-in avatar imager
* Built-in furni imager
* Walking, sitting, waving, blinking and speaking animations.
* Basic furni interaction (double clicking a furni will change its state)
* Furni particle system  (the farther elements are drawn first, so there's a 3D illusion)
* Furni animations
* Chat bubbles handled by game engine
* Catalogue
* Furni inventory
* Console / Messenger
* Navigator

## Installation
To run your own 'evolvee' you will have to consider 3 parts:
* Client: You'll have to build this project and deploy it to a web server.
* Server: evolvee.io project includes a compatible server written in Java. You'll have to deploy it too in order to make your client useful. 
 Available at: [evolvee_server](https://github.com/Josedn/evolvee_server)
* Assets: Like Habbo, avatar and furni assets are not included in the client, so you'll have to provide it with a web hosted folder with your assets.
You can generate your furni assets using this node-based tool: [evolvee_furni_converter](https://github.com/Josedn/evolvee_furni_converter)
And your avatar assets with the PHP-based tool from [evolvee_avatarimager](https://github.com/Josedn/evolvee_avatarimager). (Thanks Tsuka).

## Requirements
* Nodejs 10
* npm

## Building
To build the client execute the following commands:

    git clone https://github.com/Josedn/evolvee_client.git
    cd evolvee_client
    npm install
    npm start
Then you'll be running the React development server.
If you want to deploy it, run

    npm run build

## Related projects
* [evolvee_server](https://github.com/Josedn/evolvee_server): Official compatible evolvee server.
* [evolvee_furni_converter](https://github.com/Josedn/evolvee_furni_converter): Furni assets generation tool.
* [evolvee_avatarimager](https://github.com/Josedn/evolvee_avatarimager): Avatar assets generation tool.
* [evolvee_cms](https://github.com/Josedn/evolvee_cms): Unfinished CMS made for evolvee in React.
* [battleball_client](https://github.com/Josedn/battleball_client): evolvee 1.0 client
* [battleball_server](https://github.com/Josedn/battleball_server): evolvee 1.0 server

##
![Preview](https://i.imgur.com/PSJi35v.png)
![Preview](https://i.imgur.com/tALiJ2X.png)
![Preview](https://i.imgur.com/fjUhlpc.png)
![Preview](https://i.imgur.com/IerdB6L.png)
![Preview](https://i.imgur.com/AiFEKsP.png)
![Preview](https://i.imgur.com/hCOwdYG.png)
![Preview](https://i.imgur.com/OSMuMF4.png)
![Preview](https://i.imgur.com/LlkrmLN.png)
##
Made with <3 by Relevance.