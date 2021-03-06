import * as React from 'react';
import { Component } from 'react';

import GenericSplash from './GenericSplash';

type ErrorProps = {
    errorText: string,
};
class ErrorSplash extends Component<ErrorProps> {

    render() {
        const { errorText } = this.props;
        return (
            //@ts-ignore
            <GenericSplash>
                <p>{errorText}</p>
            </GenericSplash>
        );
    }
}

export default ErrorSplash;
