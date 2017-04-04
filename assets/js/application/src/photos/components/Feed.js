import * as React from "react";
import Photo from './Photo';

const PHOTO = 'photo';

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
            <div className="feed photos__feed">
                {this.state.posts
                    .filter(post => post.type === PHOTO)
                    .map((post, i) => {
                        return (<Photo { ...post } key={i}/>)
                    })}
            </div>
        );
    }
}