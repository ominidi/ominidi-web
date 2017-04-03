import * as React from "react";
import Photo from './Photo';

export default class Feed extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }

    componentDidMount() {
        window.fetch('/api/v1/feed')
            .then(res => res.json())
            .then(data => this.setState(data))
            .catch(e => console.log(e));
    }

    render() {
        return (
            <div className="photos__content">
                {this.state.posts.map((photo, i) => {
                    return (<Photo key={i} />)
                })}
            </div>
        );
    }
}