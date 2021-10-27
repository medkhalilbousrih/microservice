const router = require("express").Router();
const Classe = require("../models/classe");

router.get("/", async (req, res, next) => {
  try {
    const classes = await Classe.find({});
    res.json(classes);
  } catch (err) {
    next(err);
  }
});

router.post("/", async (req, res, next) => {
  try {
    const classe = new Classe(req.body);
    res.status(201).json(await classe.save());
  } catch (err) {
    next(err);
  }
});

router.put("/:id", async (req, res, next) => {
  try {
    const classe = await Classe.findById(req.params.id);

    if (!classe) {
      return res.status(404).end("classe n'existe pas");
    }

    classe.classeId = req.body.classeId;
    classe.option = req.body.option;
    classe.niveau = req.body.niveau;
    classe.description = req.body.description;

    res.json(await classe.save());
  } catch (err) {
    next(err);
  }
});

router.delete("/:id", async (req, res, next) => {
  try {
    const classe = await Classe.findById(req.params.id);
    if (classe) {
      await classe.remove();
      res.status(204).end();
    } else {
      res.status(404).end("classe n'existe pas");
    }
  } catch (err) {
    next(err);
  }
});

module.exports = router;
