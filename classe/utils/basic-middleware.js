const unknownEndPoint = (req, res) => {
  res.status(404).end();
};

const errorHandler = (err, req, res, next) => {
  res.status(500).send(err.message);
};

module.exports = { unknownEndPoint, errorHandler };
