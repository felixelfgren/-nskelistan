let doc = document, statuses = ['undefined', 'started', 'halfway', 'done', 'canceled'];

doc.querySelectorAll('todo').forEach((el) => {
  el.addEventListener('click', (e) => {
    statuses.every((status, index) => {
      if (e.target.classList.contains(status)){
        e.target.classList.replace(status, statuses[index+1 > statuses.length ? 0 : index+1]);
        return false;
      }else if(!e.target.classList.length || e.target.classList.contains('undefined')){
        e.target.classList.add(statuses[1]);
        return false;
      }else return true;
    })
  })
})