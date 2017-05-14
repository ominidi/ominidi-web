import React from 'react';
import Photo from './Photo';
import LoadingSpinner from './LoadingSpinner';

const PHOTO = 'photo';

/**
 * Render a feed oh photos.
 *
 * @author Gabriele D'Arrigo <darrigo.g@gmail.com>
 */
export default class Feed extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading: false,
            posts: []
        };
    }

    componentDidMount() {
        this.setState({loading: true});

        window.fetch('/api/v1/feed')
            .then(res => res.json())
            .then(data => this.setState(Object.assign(data, {loading: false})))
            .catch(e => console.log(e));
    }

    render() {
        return (
            <div className="feed photos__feed">
                <LoadingSpinner loading={ this.state.loading }/>
                
                {
                    this.state.posts
                        .filter(post => post.type === PHOTO)
                        .map((post, i) => {
                            return (<Photo { ...post } key={i}/>)
                        })
                }
            </div>
        );
    }
}