import * as React from 'react';
import { useState } from 'react';
import FavoriteIcon from '@mui/icons-material/Favorite';
import RecommendOutlinedIcon from '@mui/icons-material/RecommendOutlined';
import ToggleButton from '@mui/material/ToggleButton';
// import IconButton from '@mui/material/IconButton';

export default function LikeButton() {
    const [selected, setSelected] = React.useState(false);
    const [likes, setLikes] = useState(100);
    const [isClicked, setIsClicked] = useState(false);

    const handleClick = () => {
        if (isClicked) {
            setLikes(likes - 1);
        } else {
            setLikes(likes + 1);
        }
        setIsClicked(!isClicked);
    };

    return (

        // <ToggleButton
        //   value="check"
        //   selected={selected}
        //   onChange={() => {
        //     setSelected(!selected);
        //   }}
        // >
        //   <RecommendOutlinedIcon  />
        // </ToggleButton>
        <div>
            <div>
                <h1>{`${likes}`}</h1>
            </div>
            <button className={`like-button ${isClicked && 'liked'}`} onClick={handleClick}>
                <span className="likes-counter">{`Like | ${likes}`}</span>
            </button>
        </div>


    );
}