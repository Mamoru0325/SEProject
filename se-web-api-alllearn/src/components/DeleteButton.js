import React from "react";

const DeleteButton = ({ onClick }) => {
  return (
    <button type="button" class="btn btn-danger" onClick={onClick}>
      Delete
    </button>
  );
};

export default DeleteButton;
