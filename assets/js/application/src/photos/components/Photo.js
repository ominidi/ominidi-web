import React, { PropTypes } from "react";

const Photo = (props) => {
    return (
        <div className="photos__item" data-id={ props.id }>
            <article className="card">
                <figure className="card__picture">
                    <img src={ props.fullPicture } title={ props.message } alt={ props.message }/>
                </figure>

                <footer className="card__footer">
                    <h5 className="card__caption">
                        { props.message }
                    </h5>
                </footer>
            </article>
        </div>
    );
};

Photo.propTypes = {
    message: PropTypes.string,
    objectId: PropTypes.string,
    link: PropTypes.string,
    picture: PropTypes.string,
    fullPicture: PropTypes.string,
    id: PropTypes.string
};

export default Photo;