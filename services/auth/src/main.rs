fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {

    #[test]
    fn testing_stuff(){
        assert_eq!(1, 1);
    }
}
