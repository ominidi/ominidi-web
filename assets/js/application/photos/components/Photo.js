import * as React from "react";

export default (props) => {
    console.log(props);


    return (
        <div className="photos__item">
            <article className="card">
                <figure className="card__picture">
                    <img src="https://scontent-mxp1-1.xx.fbcdn.net/v/t1.0-9/15780706_231706467255399_5601506606055497757_n.jpg?oh=dcdcc343b77aa2874949841eb78dd35a&oe=596BC28E" title="" alt="" />
                </figure>

                <footer className="card__footer">
                    <h5 className="card__caption">
                        Title
                    </h5>
                </footer>
            </article>
        </div>
    );
}