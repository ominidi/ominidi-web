import React from 'react';
import PropTypes from 'prop-types';

/**
 * Photo render a single photo.
 *
 * @author Gabriele D'Arrigo <darrigo.g@gmail.com>
 * @param props
 * @returns {XML}
 * @constructor
 */
const Photo = (props) => {
    return (
        <div className="photos__item" data-id={ props.id }>
            <article className="card">
                <figure className="card__picture">
                    <img src={ props.fullPicture } title={ props.message } alt={ props.message }/>
                </figure>

                <footer className="card__footer">
                    <h5 className="card__caption title-6">
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