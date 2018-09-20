
const parser = input => {
    input = input.trim();
    const result = {name : 'ROOT', type : 'node', children : []};
    let i = 0, j = input.length;
    let curr = {tag : result};
    while (i < j) {
        const cursor = i;
        if (input[cursor] === '<') {
            const idx = input.indexOf('>', cursor);
            i = idx + 1;
            if (input[cursor + 1] === '/') {
                curr = curr.back;
            } 
            else {
                elementNode(input, cursor, idx, curr);
            }
        } 
        else {
            i = textNode(input, cursor, curr);
        }
    }

    return result;
};

const textNode = (input, cursor, curr) => {
    const idx = input.indexOf('<', cursor);
    curr.tag.children.push({type : 'text', text : input.substring(cursor, idx)});
    return idx;
};

const elementNode = (input, cursor, idx, curr) => {
    let name, isClose;
    if (input[idx - 1] === '/') {
        name = input.substring(cursor + 1, idx - 1);
        isClose = true;
    } 
    else {
        name = input.substring(cursor + 1, idx);
        isClose = false;
    }

    const tag = {name, type : 'node', children : []};
    curr.tag.children.push(tag);
    if (! isClose) {
        curr = {tag, back : curr};
        return true;
    }
    return false;
};

console.log('========================================');
const html = '<div> a <a>b</a> <img/> d </div>';
console.log(parser(html));